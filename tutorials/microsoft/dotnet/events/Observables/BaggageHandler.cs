namespace Observables;

public sealed class BaggageHandler : IObservable<BaggageInfo>
{
    private readonly HashSet<IObserver<BaggageInfo>> _observers = new();
    private readonly HashSet<BaggageInfo> _flights = new();

    public IDisposable Subscribe(IObserver<BaggageInfo> observer)
    {
        if (_observers.Add(observer))
        {
            foreach (BaggageInfo item in _flights)
            {
                observer.OnNext(item);
            }
        }

        return new Unsubscriber<BaggageInfo>(_observers, observer);
    }

    public void BaggageStatus(int flighNumber) =>
        BaggageStatus(flighNumber, string.Empty, 0);

    public void BaggageStatus(int flighNumber, string from, int carousel) 
    {
        var info = new BaggageInfo(flighNumber, from, carousel);

        if (carousel > 0 && _flights.Add(info))
        {
            foreach (IObserver<BaggageInfo> observer in _observers)
            {
                observer.OnNext(info);
            }
        }
        else if (carousel is 0)
        {
            if (_flights.RemoveWhere(flight => flight.FlightNumber == info.FlightNumber) > 0)
            {
                foreach (IObserver<BaggageInfo> observer in _observers)
                {
                    observer.OnNext(info);
                }
            }
        }
    }

    public void LastBaggageClaimend()
    {
        foreach (IObserver<BaggageInfo> observer in _observers)
        {
            observer.OnCompleted();
        }

        _observers.Clear();
    }
}
