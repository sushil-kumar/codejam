package year2018;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Universe {
	public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int numCases = scanner.nextInt();
            for (int i=0;i<numCases;++i) {
            	long totalDamage = scanner.nextLong();
            	int hacks = 0;
            	long currentDamage = 0L;
            	char[] robots = scanner.next().toCharArray();
            	List<Integer> chargePosition = new ArrayList<>();
            	List<Long> damageValue = new ArrayList<>();
            	long damage = 1L;            	
            	for (int j=0;j<robots.length;++j) {
            		if (robots[j] == 'C') {
            			chargePosition.add(j);
            			damageValue.add(damage);
            			damage *= 2;
            		} else {    			
            			currentDamage += damage;
            		}
            	}
            	
            	if (currentDamage <= totalDamage) {
            		System.out.println("Case #" + (i+1) + ": 0");
            	}
            	else if (chargePosition.size() == 0) {
            		System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
            	} else {
            		if (chargePosition.size() == robots.length)
            			System.out.println("Case #" + (i+1) + ": 0");
            		else {
            			Integer[] cPos = chargePosition.toArray(new Integer[chargePosition.size()]);
            			Long[] dVal = damageValue.toArray(new Long[damageValue.size()]);
            			int maxIndex = robots.length - 1;
            			int chargeMaxIndex = cPos.length - 1;
            			while (chargeMaxIndex >= 0) {
            				int distCanMove = maxIndex - cPos[chargeMaxIndex];
            				long lastChargeValue = dVal[chargeMaxIndex];
            				long maxDamage = distCanMove * lastChargeValue;
            				if ((currentDamage - maxDamage) >= totalDamage) {
            					hacks += distCanMove;
            					distCanMove = 0;            					
            					currentDamage -= maxDamage;
            				}
        					while (distCanMove > 0) {
        						distCanMove--;
        						hacks++;
        						currentDamage -= lastChargeValue;
        						if (currentDamage <= totalDamage) {            					
                					break;
                				}
        					}
        					chargeMaxIndex--;
        					maxIndex--;
            				
            				if (currentDamage <= totalDamage) {            					
            					break;
            				}
            			} 
            			if (currentDamage > totalDamage) {
            				System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
            			} else {
            				System.out.println("Case #" + (i+1) + ": " + hacks);
            			}
            		}
            	}
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
