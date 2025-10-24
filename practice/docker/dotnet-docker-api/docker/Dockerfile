# docker/Dockerfile

# ====================================================================
# STAGE 1: BUILD - Usado para restaurar dependências e compilar o código
# ====================================================================
FROM mcr.microsoft.com/dotnet/sdk:8.0 AS build
WORKDIR /src

# Copia o arquivo de solução e restaura dependências.
# Isso aproveita o cache do Docker se apenas o .sln mudar.
COPY ["dotnet-docker-api.sln", "."]

# Copia os arquivos de projeto (csproj) e restaura
COPY ["src/MinhaApi/MinhaApi.csproj", "src/MinhaApi/"]
RUN dotnet restore "src/MinhaApi/MinhaApi.csproj"

# Copia o código-fonte restante
COPY . .
WORKDIR "/src/src/MinhaApi"

# Constrói o projeto
RUN dotnet build "MinhaApi.csproj" -c Release -o /app/build

# ====================================================================
# STAGE 2: PUBLISH - Publica apenas os binários necessários
# ====================================================================
FROM build AS publish
# Publica para /app/publish
RUN dotnet publish "MinhaApi.csproj" -c Release -o /app/publish /p:UseAppHost=false

# ====================================================================
# STAGE 3: DEBUGGER - Baixa o vsdbg e o coloca no novo local
# ====================================================================
FROM mcr.microsoft.com/dotnet/sdk:8.0 AS debugger
WORKDIR /tmp/vsdbg_install 
# 1. Instala o vsdbg em uma subpasta "temp"
RUN curl -sSL https://aka.ms/getvsdbgsh | bash /dev/stdin -v latest -l ./temp 

# 2. MOVE o conteúdo da subpasta para a pasta que queremos COPIAR: vsdbg
# Isto garante que o caminho /tmp/vsdbg_install/vsdbg exista e contenha o conteúdo do debugger.
RUN mkdir -p vsdbg && mv ./temp/* ./vsdbg/

# ====================================================================
# STAGE 4: FINAL (SDK)
# ====================================================================
FROM mcr.microsoft.com/dotnet/sdk:8.0 AS final
WORKDIR /app
EXPOSE 8080 

# Copia os binários finais da aplicação
COPY --from=publish /app/publish .

# --------------------------------------------------------------------
# CORREÇÕES DE DEBUGGER A PARTIR DAQUI
# --------------------------------------------------------------------

# CORREÇÃO CRÍTICA DO COPY: Copia a subpasta 'vsdbg' que contém os binários
# Origem no Stage 3: /tmp/vsdbg_install/vsdbg (a pasta criada pelo script)
# Destino no Stage 4: /debugger_bin/vsdbg
COPY --from=debugger /tmp/vsdbg_install/vsdbg /debugger_bin/vsdbg

# Garante que o binário principal seja executável 
RUN chmod +x /debugger_bin/vsdbg/vsdbg

# Define a variável de ambiente para que o binário vsdbg encontre suas libs
ENV LD_LIBRARY_PATH=/debugger_bin/vsdbg:$LD_LIBRARY_PATH


# Define o ponto de entrada da aplicação
ENTRYPOINT ["dotnet", "MinhaApi.dll"]