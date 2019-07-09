import {MigrationInterface, QueryRunner} from "typeorm";

export class CreateForeignKeys1562573304632 implements MigrationInterface {

    public async up(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`ALTER TABLE "questions" ADD "user_id" int`);
        await queryRunner.query(`ALTER TABLE "answers" ADD "user_id" int`);
        await queryRunner.query(`ALTER TABLE "answers" ADD "question_id" int`);
        await queryRunner.query(`ALTER TABLE "questions" ADD CONSTRAINT "FK_5800cd25a5888174b2c40e67d4b" FOREIGN KEY ("user_id") REFERENCES "users"("id") ON DELETE NO ACTION ON UPDATE NO ACTION`);
        await queryRunner.query(`ALTER TABLE "answers" ADD CONSTRAINT "FK_f4cf663ebeca05b7a12f6a2cc97" FOREIGN KEY ("user_id") REFERENCES "users"("id") ON DELETE NO ACTION ON UPDATE NO ACTION`);
        await queryRunner.query(`ALTER TABLE "answers" ADD CONSTRAINT "FK_677120094cf6d3f12df0b9dc5d3" FOREIGN KEY ("question_id") REFERENCES "questions"("id") ON DELETE NO ACTION ON UPDATE NO ACTION`);
    }

    public async down(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`ALTER TABLE "answers" DROP CONSTRAINT "FK_677120094cf6d3f12df0b9dc5d3"`);
        await queryRunner.query(`ALTER TABLE "answers" DROP CONSTRAINT "FK_f4cf663ebeca05b7a12f6a2cc97"`);
        await queryRunner.query(`ALTER TABLE "questions" DROP CONSTRAINT "FK_5800cd25a5888174b2c40e67d4b"`);
        await queryRunner.query(`ALTER TABLE "answers" DROP COLUMN "question_id"`);
        await queryRunner.query(`ALTER TABLE "answers" DROP COLUMN "user_id"`);
        await queryRunner.query(`ALTER TABLE "questions" DROP COLUMN "user_id"`);
    }

}
