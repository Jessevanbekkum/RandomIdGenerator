package randomidprovider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 */
public class RandomParameterReader {
    private double sum = 0;
    private Random random;
    private List<Name> names = new ArrayList<Name>();

    private class Name {
        public final String name;
        public final double prob;
        public double cumulative;

        private Name(String name, double prob) {
            this.name = name;
            this.prob = prob;
            this.cumulative = sum;
            sum = cumulative + prob;
        }
    }


    RandomParameterReader(File file, long seed) throws IOException {
        if (seed == 0) {
            random = new Random();
        } else {
            random = new Random(seed);
        }

        BufferedReader inputStream = new BufferedReader(new FileReader(file));
        String line;
        while ((line = inputStream.readLine()) != null) {
            String[] fields = line.split(";");

            Name name = new Name(fields[0], Double.valueOf(fields[1]));
            names.add(name);
        }

        normalize();
    }


    RandomParameterReader(File file) throws IOException {
        this(file, 0);
    }
    private void normalize() {
        double factor = 1 / lastCumulative();
        for (Name name : names) {
            name.cumulative *= factor;
        }
    }

    private double lastCumulative() {
        return names.get(names.size() - 1).cumulative;
    }

    String getOne() {
        double r = random.nextDouble();

        int i = 0;
        for (Name name : names) {
            if (r < name.cumulative) {
                continue;
            }
            return  name.name;
        }
        throw new RuntimeException("WTF?");
    }

}
