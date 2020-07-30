# JavaRand

## What is Java Rand?
Java Rand is a spiritual successor of the Lava Rand Project. [Wikipedia Page](https://en.wikipedia.org/wiki/Lavarand) [Original Website (displayed using the Wayback Machine)](https://web.archive.org/web/19971210213248/http://lavarand.sgi.com:80/)
Java Rand is a truly random number generator (TRNG).

## How is Java Rand "truly" random?
While it's true that Java Rand uses a psuedo-random number generator, it's seed is truly random because it is a digitization of a chaotic system. 
Since that chaotic system (a lava lamp) is extremely unpredictable, even at short intervals, Java Rand achieves true randomness for the first number it generates per seed. Java Rand generates a new seed for each new number, thus guaranteeing true randomness each time it generates a new number.

## What if I don't have a lava lamp handy?
Simply cover the lens of your webcam with a black piece of paper, crank up your camera's exposure (if you can), and you should get enough noise to seed the generator nicely. 
