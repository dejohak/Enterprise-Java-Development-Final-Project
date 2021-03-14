export class Likes {

    constructor(
        private _id: number,
        private _likes: number,
        private _dislikes: number
    ) {}

    public get dislikes(): number {
        return this._dislikes;
    }
    public set dislikes(value: number) {
        this._dislikes = value;
    }
    public get likes(): number {
        return this._likes;
    }
    public set likes(value: number) {
        this._likes = value;
    }
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
}
