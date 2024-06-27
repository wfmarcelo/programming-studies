namespace Observables;

public class ArrivalsMonitor : IObserver<BaggageInfo>
{
    private readonly string _name;
    private readonly List<string> _flights = new();
    private readonly string _format = "{0,-20} {1,5}  {2,3}";
    private IDisposable? _cancellation;

    public ArrivalsMonitor(string name)
    {
        ArgumentException.ThrowIfNullOrEmpty(name);
        _name = name;
    }

    public virtual void Subscribe(BaggageHandler provider) =>
        _cancellation = provider.Subscribe(this);

    public virtual void Unsubscribe()
    {
        _cancellation?.Dispose();
        _flights.Clear();
    }
    public void OnCompleted() => _flights.Clear();

    public void OnError(Exception error)
    {
        throw new NotImplementedException();
    }

    public void OnNext(BaggageInfo info)
    {
        bool updated = false;

        if (info.Carousel is 0)
        {
            string flighNumber = string.Format("{0,5}", info.FlightNumber);
            for (int index = _flights.Count - 1; index >= 0; index--)
            {
                string flightInfo = _flights[index];
                if (flightInfo.Substring(21, 5).Equals(flighNumber))
                {
                    updated = true;
                    _flights.RemoveAt(index);
                }
            }
        }
        else
        {
            string flightInfo = string.Format(_format, info.From, info.FlightNumber, info.Carousel);
            if (_flights.Contains(flightInfo) is false)
            {
                _flights.Add(flightInfo);
                updated = true;
            }
        }

        if (updated)
        {
            _flights.Sort();
            Console.WriteLine($"Arrivals information from {_name}");
            foreach (string flightInfo in _flights)
            {
                Console.WriteLine(flightInfo);
            }

            Console.WriteLine();
        }
    }
}
