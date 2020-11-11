package com.nackademin;

import com.nackademin.VinstLott;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] arg) throws IOException {
        VinstLott[] vinstLotter = VinstLott.skapaVinstLottFranFil(10);
        VinstLott.startaLotteri(vinstLotter);
    }
}
