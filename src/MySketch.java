/**
 * Created by Stephen Mc Ateer on 29 Nov 2014.
 */

import processing.core.*;

public class MySketch extends PApplet {

    // image settings
    int width = 1800;
    int height = 1000;
    boolean[] my_primes = new boolean[width*height];

    // check if an integer is a prime
    private boolean is_prime ( int n ) {
        if ( n%2 == 0 ) return false;
        for ( int i = 3; i*i <= n; i += 2 ) if ( n%i == 0 ) return false;
        return true;
    }

    @Override
    public void setup() {
        size(width, height);
    }

    @Override
    public void draw() {
        // First run: calculate the required primes
        if ( frameCount == 1 ) for (int i = 0; i < width * height; i++) if (is_prime(i + 1)) my_primes[i] = true;

        // Print the line drawing area width
        System.out.println( mouseX );

        // primes -> white, non-primes -> black
        clear();
        for ( int i = 0; i < mouseX*height; i++ ) if ( my_primes[i] ) set( i%mouseX, i/mouseX, color(255) );
    }
}
