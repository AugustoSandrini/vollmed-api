ALTER TABLE pacientes ADD CONSTRAINT unique_cpf UNIQUE (cpf);
ALTER TABLE pacientes MODIFY cpf VARCHAR(100);
