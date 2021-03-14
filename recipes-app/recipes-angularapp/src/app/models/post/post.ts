export class Post {

    constructor(
        private _id: number,
        private _title: string,
        private _name: string,
        private _comment: string
    ){}

    public get comment(): string {
        return this._comment;
    }
    public set comment(value: string) {
        this._comment = value;
    }
    public get name(): string {
        return this._name;
    }
    public set name(value: string) {
        this._name = value;
    }
    public get title(): string {
        return this._title;
    }
    public set title(value: string) {
     this._title = value;
    }
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
}
