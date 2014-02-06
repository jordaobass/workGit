Original:

CREATE TABLE paciente
(
  cod_paciente serial NOT NULL,
  cpf character varying NOT NULL,
  nome character varying NOT NULL,
  datanasc date,
  email character varying,
  CONSTRAINT paciente_pkey PRIMARY KEY (cod_paciente ),
 constraint paciente_cod_end_fkey foreign key(cod_end) references endereco(cod_end)

)ALTER TABLE paciente ADD CONSTRAINT cpf UNIQUE (cpf);

CREATE TABLE telefone
(
 cod_tel serial NOT NULL,
  cod_paciente  integer not null,
  tipo_telefone character varying,
  numero character varying(30) NOT NULL,

CONSTRAINT telefone_pkey PRIMARY KEY (cod_tel),
)

CREATE TABLE endereco
(
  cidade character varying(30) NOT NULL,
  estado character varying(30) NOT NULL,
  bairro character varying(30) NOT NULL,
  rua character varying(30) NOT NULL,
  numero character varying(20),
  complemento character varying(30),
  cep character varying(12) NOT NULL,

)

CREATE TABLE plano
(
  cod_plano serial not null,
 	nome character varying(30)not null,

constraint plano_pkey primary key (cod_plano)
)

CREATE TABLE consulta
(
    data date,
    cod_consulta serial not null,
    cod_paciente integer not null,
   cod_plano integer,
  
   CONSTRAINT consulta_pkey PRIMARY KEY (cod_consulta ),
   CONSTRAINT consulta_cod_paciente_fkey FOREIGN KEY (cod_paciente)
      REFERENCES paciente (cod_paciente) ON UPDATE NO ACTION ON DELETE CASCADE,
  	CONSTRAINT consulta_cod_plano_fkey FOREIGN KEY (cod_plano)
      REFERENCES plano (cod_plano) ON UPDATE NO ACTION ON DELETE CASCADE
)

create table plano_paciente(

  cod_paciente integer not null,
  cod_plano integer not null,
  data_val date not null,

  constraint plano_paciente_pkey primary key (cod_paciente, cod_plano),
  constraint plano_paciente_cod_paciente_fkey foreign key (cod_paciente) references paciente ( cod_paciente)ON UPDATE NO ACTION ON DELETE CASCADE,
  constraint plano_paciente_cod_plano_fkey foreign key (cod_plano) references plano(cod_plano)ON UPDATE NO ACTION ON DELETE CASCADE

)

CREATE TABLE data
(
  id_data serial NOT NULL,
  datadisponivel date ,
  CONSTRAINT data_pkey PRIMARY KEY (id_data)
)
