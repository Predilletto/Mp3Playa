DROP TABLE IF EXISTS SONGS;

create table songs (
    TITLE VARCHAR (100),
    ARTIST VARCHAR (50),
    GENRE VARCHAR (50),
    FILEPATH VARCHAR (250),
    PRIMARY KEY (FILEPATH)
); 

INSERT INTO songs VALUES (
    'Eu Bem Que Te Avisei','Mc Delux (Love FUNK)', 'FUNK','src\com\predilleto\repository\musicUsed\Eu_Bem_Que_Te_Avisei.mp3'
), ('Não Se Apavora', 'Gaab', 'FUNK','src\com\predilleto\repository\musicUsed\Nao_Se_Apavora.mp3'),
('Joga Na Cara', 'MC Braz', 'FUNK','src\com\predilleto\repository\musicUsed\Joga_na_Cara.mp3'),
('Kikando e Me Olhando','MC Braz', 'FUNK','src\com\predilleto\repository\musicUsed\Kikando_e_Me_Olhando.mp3'),
('Simplesmente Ela','Mc Gabzin', 'FUNK', 'src\com\predilleto\repository\musicUsed\SIMPLESMENTE_ELA.mp3'),
('Gostosinho Tu Cai', 'MC pepeu','FUNK' , 'src\com\predilleto\repository\musicUsed\Gostosinho_Tu_Cai.mp3')
, ('Maigo do Som','MC WM', 'FUNK','src\com\predilleto\repository\musicUsed\Magico_do_Som.mp3'),
('Vou com Carinho', 'MC Don Juan', 'FUNK', 'src\com\predilleto\repository\musicUsed\VOU_COM_CARINHo.mp3')
,('Cooped Up','Post Malone','HIP HOP','src\com\predilleto\repository\musicUsed\Cooped_Up.mp3'),
('Fair Trade', 'Drake','HIP HOP' ,'src\com\predilleto\repository\musicUsed\Fair_Trade.mp3')
, ('Falling Back','Drake', 'HIP HOP', 'src\com\predilleto\repository\musicUsed\Falling_Back_Audio.mp3'),
('Jimmy Cooks', 'Drake', 'HIP HOP','src\com\predilleto\repository\musicUsed\Jimmy_Cooks.mp3' )
,('Mood','24K Gold','HIP HOP','src\com\predilleto\repository\musicUsed\Mood.mp3')
,('N95','Kendrick Lamar', 'HIP HOP', 'src\com\predilleto\repository\musicUsed\N95.mp3'), 
('Praise God','Kanye West','HIP HOP', 'src\com\predilleto\repository\musicUsed\Praise_god.mp3'),
('Sicko Mode','Travis Scott', 'HIP HOP', 'src\com\predilleto\repository\musicUsed\SICKO_MODE.mp3')
,('Dont You Evah','Spoon','INDIE','src\com\predilleto\repository\musicUsed\Dont_You_Evah.mp3')
,('Freaks','Surf Curse', 'INDIE', 'src\com\predilleto\repository\musicUsed\Freaks.mp3'),
('I Think I Like When It Rains','WILLIS', 'INDIE', 'src\com\predilleto\repository\musicUsed\I_Think_I_Like_When_It_Rains.mp3')
,('Indie Pop Type Beat', 'Billy Marchiafava','INDIE','src\com\predilleto\repository\musicUsed\Indie_Pop_Type_Beat.mp3')
,('Matchstick','American Royalty','INDIE','src\com\predilleto\repository\musicUsed\Matchstick.mp3'),
('Notion','The Rare Occasions','INDIE', 'src\com\predilleto\repository\musicUsed\Notion.mp3')
,('On the Level','Marc Demarco','INDIE','src\com\predilleto\repository\musicUsed\On_the_Level.mp3'),
('Wolf Like Me', 'Tv on The Radio','INDIE','src\com\predilleto\repository\musicUsed\Wolf_Like_Me.mp3'),
('About Damn Time','Lizzo','POP','src\com\predilleto\repository\musicUsed\About_Damn_Time.mp3'),
('As it Was','Harry Styles','POP','src\com\predilleto\repository\musicUsed\As It Was.mp3'),
('Dançarina(REMIX)','Pedro Sampaio','POP','src\com\predilleto\repository\musicUsed\DANARINA_Remix.mp3'),
('Envolver','Anitta','POP','src\com\predilleto\repository\musicUsed\Envolver.mp3'),
('Ghost','Justin Bieber','POP','src\com\predilleto\repository\musicUsed\Ghost.mp3')
,('Industry Baby','Lil Nas X','POP','src\com\predilleto\repository\musicUsed\Industry_Baby.mp3'),
('Provenza','Karol G','POP','src\com\predilleto\repository\musicUsed\PROVENZA.mp3'),
('Woman','Doja Cat','POP','src\com\predilleto\repository\musicUsed\Woman.mp3'),
('Boulevard of Broken Dreams','Green Day','ROCK','src\com\predilleto\repository\musicUsed\Boulevard_of_Broken_Dreams.mp3'),
('Cant Stop','Red Hot Chilli Peppers', 'ROCK', 'src\com\predilleto\repository\musicUsed\Cant_Stop.mp3'),
('Chop Suey','System of Down','ROCK','src\com\predilleto\repository\musicUsed\Chop_Suey_HQ.mp3' ),
('Hysteria', 'Muse','ROCK', 'src\com\predilleto\repository\musicUsed\Hysteria.mp3'),
('Kryptonite','3 Doors Down', 'ROCK', 'src\com\predilleto\repository\musicUsed\Kryptonite.mp3'), 
('Mr Brightside', 'The Killers', 'ROCK','src\com\predilleto\repository\musicUsed\Mr_Brightside.mp3'),
('Seven Nation Army','The White Stripes','ROCK', 'src\com\predilleto\repository\musicUsed\Seven_Nation_Army.mp3'),
('What Ive Done','Linkin Park','ROCK','src\com\predilleto\repository\musicUsed\What_Ive_Done.mp3'),
('Erro Planejado','Luan Santana','SERTANEJO', 'src\com\predilleto\repository\musicUsed\ERRO_PLANEJADO.mp3'),
('Evento Cancelado','Henrique & Juliano','SERTANEJO','src\com\predilleto\repository\musicUsed\EVENTO_CANCELADO.mp3'),
('Meu Numero','Hugo & Guilherme','SERTANEJO', 'src\com\predilleto\repository\musicUsed\MEU_NUMERO.mp3'), 
('Nem Namorado Nem Ficante','Israel & Rodolfo','SERTANEJO','src\com\predilleto\repository\musicUsed\NEM_NAMORADO_E_NEM_FICANTE.mp3'),
('Não Pega Ninguém Ainda','Gusttavo Lima','SERTANEJO','src\com\predilleto\repository\musicUsed\No_Pega_Ningum_Ai.mp3'),
('Pino da Granada','Murilo Huff','SERTANEJO','src\com\predilleto\repository\musicUsed\Pino_da_Granada.mp3'),
('Termina Comigo Antes','Gusttavo Lima','SERTANEJO','src\com\predilleto\repository\musicUsed\Termina_Comigo_Antes.mp3'),
('Todo Seu','Jorge & Mateus', 'SERTANEJO' ,'src\com\predilleto\repository\musicUsed\Todo_Seu.mp3')
;
 



