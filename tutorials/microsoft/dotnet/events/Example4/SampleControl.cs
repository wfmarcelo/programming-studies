using System.ComponentModel;

namespace Example4;

public class SampleControl : Component
{
    protected EventHandlerList listEventDelegates = new EventHandlerList();

    static readonly object mouseDownEventKey = new object();
    static readonly object mouseUpEventKey = new object();

    public event MouseEventHandler MouseDown
    {
        add
        {
            listEventDelegates.AddHandler(mouseDownEventKey, value);
        }

        remove
        {
            listEventDelegates.RemoveHandler(mouseDownEventKey, value);
        }
    }

    private void OnMouseDown(MouseEventArgs e)
    {
        MouseEventHandler mouseEventDelegate =
            (MouseEventHandler) listEventDelegates[mouseDownEventKey];
        mouseEventDelegate(this, e);
    }

    public event MouseEventHandler MouseUp
    {
        add
        {
            listEventDelegates.AddHandler(mouseUpEventKey, value);
        }

        remove
        {
            listEventDelegates.RemoveHandler(mouseUpEventKey, value);
        }
    }
    
    private void OnMouseUp(MouseEventArgs e)
    {
        MouseEventHandler mouseEventDelegate =
            (MouseEventHandler) listEventDelegates[mouseUpEventKey];
        mouseEventDelegate(this, e);
    }
   
}

public class MouseEventArgs : EventArgs;

public delegate void MouseEventHandler(object sender, MouseEventArgs e);
