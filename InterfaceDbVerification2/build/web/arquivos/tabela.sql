
$efndskfmmadsfpfs
CREATE TABLE cadeira1(
      casa1 datatype COMMENT 'casa zareere',
      column2 datatype,
      column3 datatype,
      columnN datatype,
      PRIMARY KEY( column1 )
);

dasdasddasasda
      --COMMENT
CREATE TABLE cadeira2(
   casa1 datatype COMMENT  'casa zareere',--nnndndnzknzdkl-
   column2 datatype,
   column3 datatype,
   columnN datatype
   PRIMARY KEY( column1 )
);
CREATE TABLE IF NOT EXISTS `padrao_documento`.`T_SPDC_PRMT_ACSSO_TXTO` (
  `ID_PRMT_ACSSO_TXTO` INT NOT NULL,
  `DS_PRMT_ACSSO_TXTO` VARCHAR(100) NULL COMMENT 'Descricao do parametro de acesso a texto. Por exemplo, PUBLIC CLASS, CREATE TABLE.',
  `NU_INIC_ACSSO_TXTO` INT NULL COMMENT 'Numero do inicio de acesso ao texto lido.',
  `NU_FIM_ACSSO_TXTO` INT NULL COMMENT 'Numero do fim de acesso ao texto lido.',
  `NU_TMHO_TXTO` INT NULL COMMENT 'Numero do tamanho do texto.',
  `FL_FIM_ACSSO_TXTO` VARCHAR(5) NULL COMMENT 'Flag de fim de leitura do acesso ao texto a ser reconhecido na leitura de um documento a ser verificado de acordo com os padrões.',
  `IC_TIPO_ACSSO_TXTO` VARCHAR(100) NULL COMMENT 'Indicador do tipo do texto a ser lido. (T) Tabela, (P) Primary Key, Foreign Key (F).',
  `FL_PLVR_CHVE_SGBD` VARCHAR(1) NULL COMMENT 'Flag para definir se o parâmetro é uma palavra-chave de comandos de scripts de Sistema Gerenciador de Banco de Dados.',
  PRIMARY KEY (`ID_PRMT_ACSSO_TXTO`));