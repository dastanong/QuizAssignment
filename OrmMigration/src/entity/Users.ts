import {Entity, PrimaryGeneratedColumn, Column, OneToMany} from "typeorm";
import { Questions } from "./Questions";
import { Answers } from "./Answers";

@Entity()
export class Users {

    @PrimaryGeneratedColumn()
    id: number;

    @Column()
    name: string;

    @Column()
    email: string;

    @OneToMany(type => Questions, questions => questions.users)
    questions: Questions[]

    @OneToMany(type => Answers, answers => answers.users)
    answers: Answers[]
}
