import {MigrationInterface, QueryRunner} from "typeorm";

export class CreateAllTables1562571567868 implements MigrationInterface {

    public async up(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`CREATE TABLE "answers" ("id" int NOT NULL IDENTITY(1,1), "text" nvarchar(255) NOT NULL, CONSTRAINT "PK_9c32cec6c71e06da0254f2226c6" PRIMARY KEY ("id"))`);
        await queryRunner.query(`CREATE TABLE "questions" ("id" int NOT NULL IDENTITY(1,1), "description" nvarchar(255) NOT NULL, CONSTRAINT "PK_08a6d4b0f49ff300bf3a0ca60ac" PRIMARY KEY ("id"))`);
        await queryRunner.query(`CREATE TABLE "users" ("id" int NOT NULL IDENTITY(1,1), "name" nvarchar(255) NOT NULL, "email" nvarchar(255) NOT NULL, CONSTRAINT "PK_a3ffb1c0c8416b9fc6f907b7433" PRIMARY KEY ("id"))`);
    }

    public async down(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`DROP TABLE "users"`);
        await queryRunner.query(`DROP TABLE "questions"`);
        await queryRunner.query(`DROP TABLE "answers"`);
    }

}
