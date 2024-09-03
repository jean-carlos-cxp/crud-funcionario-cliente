import { Address } from "./Address";

export interface Employee {
    id?: number;
    nome: string;
    cpf: string;
    dataNascimento: Date;
    cargo: string;
    endereco: Address;
}