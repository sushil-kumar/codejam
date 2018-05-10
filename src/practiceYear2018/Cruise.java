package practiceYear2018;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Cruise {
	public static void main(String[] args) {
        Scanner scanner = null;        
        try {
            scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int numCases = scanner.nextInt();
            DecimalFormat df = new DecimalFormat("#.000000");
            for (int i=0;i<numCases;++i) {
                System.out.print("Case #" + (i+1) + ": ");
                double totalDistance = scanner.nextDouble();
                int totalHorses = scanner.nextInt();
                double time = 0;
                double temp;
                for (int j=0;j<totalHorses;++j) {
            		double hDist = scanner.nextDouble();
            		double hSpeed = scanner.nextDouble();
            		temp = (totalDistance - hDist) / hSpeed;
            		if (temp > time)
            			time = temp;
            	}
                System.out.println(df.format(totalDistance / time));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (scanner != null)
                    scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
}
