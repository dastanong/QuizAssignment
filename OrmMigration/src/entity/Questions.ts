import {Entity, PrimaryGeneratedColumn, Column, JoinColumn, ManyToOne, OneToMany} from "typeorm";
import { Users } from "./Users";
import { Answers } from "./Answers";

@Entity()
export class Questions {

    @PrimaryGeneratedColumn()
    id: number;

    @Column()
    description: string;

    @ManyToOne(type => Users, users => users.questions)
    @JoinColumn({name: "user_id"})
    users: Users[]

    @OneToMany(type => Answers, answers => answers.questions)
    answers: Answers[]
}