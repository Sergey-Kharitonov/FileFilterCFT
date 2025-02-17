package srgcft;

import srgcft.stats.FloatStats;
import srgcft.stats.IntegerStats;
import srgcft.stats.StringStats;

import java.io.*;
import java.math.BigDecimal;

public class Filter {
    static FloatStats statsFloat = new FloatStats();
    static IntegerStats statsInteger = new IntegerStats();
    static StringStats statsString = new StringStats();

    static boolean integerFilesAppendArg;
    static boolean floatFilesAppendArg;
    static boolean stringFilesAppendArg;

    public Filter(boolean filesAppendArg) {
        integerFilesAppendArg = filesAppendArg;
        floatFilesAppendArg = filesAppendArg;
        stringFilesAppendArg = filesAppendArg;
    }

    void filterString(String str, String pathOutputFiles, String outFilePrefix) throws IOException {

        if (str.matches("^\\d+$")) {
            statsInteger.setIntegerStats(Long.parseLong(str));
            outputWriter(new File(pathOutputFiles + outFilePrefix + "integers.txt"), str, integerFilesAppendArg);
            integerFilesAppendArg = true;
        } else if (str.matches("[+-]?(\\d+([.]\\d*)?([eE][+-]?\\d+)?|[.]\\d+([eE][+-]?\\d+)?)")) {
            statsFloat.setFloatStats(new BigDecimal(str));
            outputWriter(new File(pathOutputFiles + outFilePrefix + "floats.txt"), str, floatFilesAppendArg);
            floatFilesAppendArg = true;
        } else {
            statsString.setStringStats(str);
            outputWriter(new File(pathOutputFiles + outFilePrefix + "strings.txt"), str, stringFilesAppendArg);
            stringFilesAppendArg = true;
        }
    }

    static void outputWriter(File file, String string, boolean fileAppendArg) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        try (FileWriter fw = new FileWriter(file, fileAppendArg);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
