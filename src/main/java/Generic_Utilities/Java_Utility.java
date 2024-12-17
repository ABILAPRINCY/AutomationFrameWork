package Generic_Utilities;

import java.util.Random;

public class Java_Utility
{

/**
 * Random number generation to avoid duplicate values
 * @author Abila
 * @return
 */
public int getRandomNum()
{
Random ran = new Random();
int value = ran.nextInt(1000);
return value;
}
}

