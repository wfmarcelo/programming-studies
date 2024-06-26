﻿namespace Example1;
class Program
{
    private static void Main(string[] args)
    {
        Counter c = new Counter(new Random().Next(10));
        c.ThresholdReached += c_ThresholdReached;
        
        Console.WriteLine("press 'a' key to increase total");
        while (Console.ReadKey(true).KeyChar == 'a')
        {
            Console.WriteLine("adding one");
            c.Add(1);
        }
    }

    static void c_ThresholdReached(object? sender, EventArgs e)
    {
        Console.WriteLine("The threshold was reached.");
        Environment.Exit(0);
    }
}
