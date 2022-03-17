package com.example.john_deere_demo;

import java.util.Arrays;
import java.util.List;

public class Literals {
    public static final List<String> unwantedWords = Arrays.asList(("the,of,to,and,a,in,is,it,you,that," +
            "he,was,for,on,are,with,as,i,his,they,be,at,one,have,this,from,or,had,by,not,word,but,what,some" +
            ",we,can,out,other,were,all,there,when,up,use,your,how,said,an,each,she").split(","));

    public static final List<String> mixOfWantedAndWantedWords = Arrays.asList((("The Project Gutenberg eBook").split(",")));
}
