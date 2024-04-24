
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.Hosting;
using OptionsPattern;

HostApplicationBuilder builder = Host.CreateApplicationBuilder(args);

builder.Configuration.Sources.Clear();

IHostEnvironment env = builder.Environment;

builder.Configuration
    .AddJsonFile("appsettings.json", optional: true, reloadOnChange: true)
    .AddJsonFile($"appsettings.{env.EnvironmentName}.json", true, true);

// TransientFaultHandlingOptions options = new ();
// builder.Configuration.GetSection(nameof(TransientFaultHandlingOptions))
//     .Bind(options);

var options =
    builder.Configuration.GetSection(nameof(TransientFaultHandlingOptions))
    .Get<TransientFaultHandlingOptions>();


Console.WriteLine($"TransientFaultHandlingOptions.Enabled={options.Enabled}");
Console.WriteLine($"TransientFaultHandlingOptions.AutoRetryDelay={options.AutoRetryDelay}");

using IHost host = builder.Build();

await host.RunAsync();
