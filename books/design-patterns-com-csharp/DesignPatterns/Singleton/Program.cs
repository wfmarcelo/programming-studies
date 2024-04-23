using SingletonPattern;

Singleton jogador1 = Singleton.GetInstancia;
jogador1.Mensagem("Jogador 1: A bola está comigo no meio do campo.");

Singleton jogador2 = Singleton.GetInstancia;
jogador2.Mensagem("Jogador 2: recebeu a bola.");

Singleton jogador3 = Singleton.GetInstancia;
jogador3.Mensagem("Jogador 3: recebeu o lançamento na linha de fundo.");

Console.ReadLine();