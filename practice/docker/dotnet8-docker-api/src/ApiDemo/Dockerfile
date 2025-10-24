# ===== Etapa de build =====
FROM mcr.microsoft.com/dotnet/sdk:8.0 AS build
WORKDIR /src

# Copia csproj e restaura (aproveita cache)
COPY ApiDemo.csproj ./
RUN dotnet restore

# Copia o restante e publica
COPY . .
ARG CONFIGURATION=Release
RUN dotnet publish -c $CONFIGURATION -o /app --no-restore

# ===== Etapa de runtime =====
FROM mcr.microsoft.com/dotnet/aspnet:8.0 AS final
WORKDIR /app
COPY --from=build /app ./

# Porta configurada no Program.cs
EXPOSE 8080
ENV ASPNETCORE_URLS=http://0.0.0.0:8080

ENTRYPOINT ["dotnet", "ApiDemo.dll"]