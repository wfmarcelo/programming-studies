namespace Example3;

public class ThresholdReachedEventArgs : EventArgs
{
    public int Threshold { get; set; }
    public DateTime TimeReached { get; set; }
}

public delegate void ThresholdReachedEventHandler(object sender, ThresholdReachedEventArgs e);