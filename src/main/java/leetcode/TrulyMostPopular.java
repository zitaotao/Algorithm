package leetcode;

import disjoint_set.DisjointSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面试题 17.07. 婴儿名字
 * https://leetcode-cn.com/problems/baby-names-lcci/
 * @author jzt
 * @version 1.0
 * @date 2021-02-20 10:12
 **/
public class TrulyMostPopular {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        if (synonyms==null){
            return names;
        }
        DisjointSet disjointSet = new DisjointSet();
        disjointSet.init(synonyms.length*2);
        List<String> synonymList = new ArrayList<>();
        Map<String,Integer> synonymMap = new HashMap<>();
        for (String synonym : synonyms) {
            synonym = synonym.replace("(","").replace(")","");
            String[] tempArray = synonym.split("[,]");
            if (!synonymMap.containsKey(tempArray[0])){
                synonymMap.put(tempArray[0],0);
                synonymList.add(tempArray[0]);
            }
            if (!synonymMap.containsKey(tempArray[1])){
                synonymMap.put(tempArray[1],0);
                synonymList.add(tempArray[1]);
            }
            synonymMap.put(tempArray[0],synonymMap.get(tempArray[0])+1);
            synonymMap.put(tempArray[1],synonymMap.get(tempArray[1])+1);
        }
        List<String> simpleNameList = new ArrayList<>();
        for (String name : names) {
            String simpleName = name.split("[(]")[0];
            simpleNameList.add(simpleName);
        }
        for (String synonym : synonyms) {
            synonym = synonym.replace("(","").replace(")","");
            String[] tempArray = synonym.split("[,]");
            if (simpleNameList.indexOf(tempArray[0])==-1){
                int x = synonymList.indexOf(tempArray[1]);
                int y = synonymList.indexOf(tempArray[0]);
                disjointSet.union(x,y);
            }
            if (simpleNameList.indexOf(tempArray[1])==-1){
                int x = synonymList.indexOf(tempArray[0]);
                int y = synonymList.indexOf(tempArray[1]);
                disjointSet.union(x,y);
            }
            if (simpleNameList.indexOf(tempArray[1])!=-1&&simpleNameList.indexOf(tempArray[0])!=-1){
                int x = simpleNameList.indexOf(tempArray[0])<simpleNameList.indexOf(tempArray[1])?synonymList.indexOf(tempArray[0]):synonymList.indexOf(tempArray[1]);
                int y = simpleNameList.indexOf(tempArray[0])>simpleNameList.indexOf(tempArray[1])?synonymList.indexOf(tempArray[0]):synonymList.indexOf(tempArray[1]);
                disjointSet.union(x,y);
            }

        }
        Map<String,Integer> disNameMap = new HashMap<>();
        List<String> nameOrder = new ArrayList<>();
        for (String name : names) {
            String simpleName  = name.split("[(]")[0];
            String count  = name.replace("(","").replace(")","").replace(simpleName,"");
            if (synonymList.indexOf(simpleName)==-1){
                nameOrder.add(simpleName);
                disNameMap.put(simpleName,Integer.valueOf(count));
            }
            if (synonymList.indexOf(simpleName)!=-1&&disjointSet.find(synonymList.indexOf(simpleName))==synonymList.indexOf(simpleName)){
                if (!disNameMap.containsKey(simpleName)){
                    disNameMap.put(simpleName,0);
                    nameOrder.add(simpleName);
                }
                disNameMap.put(simpleName,disNameMap.get(simpleName)+Integer.valueOf(count));

            }
            if (synonymList.indexOf(simpleName)!=-1&&disjointSet.find(synonymList.indexOf(simpleName))!=synonymList.indexOf(simpleName)){
                String sameName = synonymList.get(disjointSet.find(synonymList.indexOf(simpleName)));
                if (!disNameMap.containsKey(sameName)){
                    nameOrder.add(sameName);
                    disNameMap.put(sameName,0);
                }
                disNameMap.put(sameName,disNameMap.get(sameName)+Integer.valueOf(count));
            }
        }
        List<String> res = new ArrayList<>();
        nameOrder.forEach(ele->{
            res.add(ele+"("+disNameMap.get(ele)+")");
        });
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        new TrulyMostPopular().trulyMostPopular(new String[]{
                "Fcclu(70)","Ommjh(63)","Dnsay(60)","Qbmk(45)","Unsb(26)","Gauuk(75)","Wzyyim(34)","Bnea(55)","Kri(71)","Qnaakk(76)","Gnplfi(68)","Hfp(97)","Qoi(70)","Ijveol(46)","Iidh(64)","Qiy(26)","Mcnef(59)","Hvueqc(91)","Obcbxb(54)","Dhe(79)","Jfq(26)","Uwjsu(41)","Wfmspz(39)","Ebov(96)","Ofl(72)","Uvkdpn(71)","Avcp(41)","Msyr(9)","Pgfpma(95)","Vbp(89)","Koaak(53)","Qyqifg(85)","Dwayf(97)","Oltadg(95)","Mwwvj(70)","Uxf(74)","Qvjp(6)","Grqrg(81)","Naf(3)","Xjjol(62)","Ibink(32)","Qxabri(41)","Ucqh(51)","Mtz(72)","Aeax(82)","Kxutz(5)","Qweye(15)","Ard(82)","Chycnm(4)","Hcvcgc(97)","Knpuq(61)","Yeekgc(11)","Ntfr(70)","Lucf(62)","Uhsg(23)","Csh(39)","Txixz(87)","Kgabb(80)","Weusps(79)","Nuq(61)","Drzsnw(87)","Xxmsn(98)","Onnev(77)","Owh(64)","Fpaf(46)","Hvia(6)","Kufa(95)","Chhmx(66)","Avmzs(39)","Okwuq(96)","Hrschk(30)","Ffwni(67)","Wpagta(25)","Npilye(14)","Axwtno(57)","Qxkjt(31)","Dwifi(51)","Kasgmw(95)","Vgxj(11)","Nsgbth(26)","Nzaz(51)","Owk(87)","Yjc(94)","Hljt(21)","Jvqg(47)","Alrksy(69)","Tlv(95)","Acohsf(86)","Qejo(60)","Gbclj(20)","Nekuam(17)","Meutux(64)","Tuvzkd(85)","Fvkhz(98)","Rngl(12)","Gbkq(77)","Uzgx(65)","Ghc(15)","Qsc(48)","Siv(47)"
        },new String[]{"(Gnplfi,Qxabri)","(Uzgx,Siv)","(Bnea,Lucf)","(Qnaakk,Msyr)","(Grqrg,Gbclj)","(Uhsg,Qejo)","(Csh,Wpagta)","(Xjjol,Lucf)","(Qoi,Obcbxb)","(Npilye,Vgxj)","(Aeax,Ghc)","(Txixz,Ffwni)","(Qweye,Qsc)","(Kri,Tuvzkd)","(Ommjh,Vbp)","(Pgfpma,Xxmsn)","(Uhsg,Csh)","(Qvjp,Kxutz)","(Qxkjt,Tlv)","(Wfmspz,Owk)","(Dwayf,Chycnm)","(Iidh,Qvjp)","(Dnsay,Rngl)","(Qweye,Tlv)","(Wzyyim,Kxutz)","(Hvueqc,Qejo)","(Tlv,Ghc)","(Hvia,Fvkhz)","(Msyr,Owk)","(Hrschk,Hljt)","(Owh,Gbclj)","(Dwifi,Uzgx)","(Iidh,Fpaf)","(Iidh,Meutux)","(Txixz,Ghc)","(Gbclj,Qsc)","(Kgabb,Tuvzkd)","(Uwjsu,Grqrg)","(Vbp,Dwayf)","(Xxmsn,Chhmx)","(Uxf,Uzgx)"});
    }
}
