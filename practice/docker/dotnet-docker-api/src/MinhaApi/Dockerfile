FROM mcr.microsoft.com/dotnet/aspnet:8.0 AS base
WORKDIR /app
EXPOSE 5195

ENV ASPNETCORE_URLS=http://+:5195

USER app
FROM --platform=$BUILDPLATFORM mcr.microsoft.com/dotnet/sdk:8.0 AS build
ARG configuration=Release
WORKDIR /src
COPY ["src/MinhaApi/MinhaApi.csproj", "src/MinhaApi/"]
RUN dotnet restore "src/MinhaApi/MinhaApi.csproj"
COPY . .
WORKDIR "/src/src/MinhaApi"
RUN dotnet build "MinhaApi.csproj" -c $configuration -o /app/build

FROM build AS publish
ARG configuration=Release
RUN dotnet publish "MinhaApi.csproj" -c $configuration -o /app/publish /p:UseAppHost=false

FROM base AS final
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "MinhaApi.dll"]
