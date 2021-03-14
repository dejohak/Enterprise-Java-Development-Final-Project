import { Ingredient } from "../../classes/ingredient"

export class Recipe {

    constructor (
        private _id: number,
        private _flavour: string,
        private _foodType: string,
        private _prepTime: number,
        private _ingredients: Ingredient[] = [],
        private _name: string,
        private _preparation: string,
        private _photo: string
        ) {}

    public get photo(): string {
        return this._photo
    }
    public set photo(value: string) {
        this._photo = value
    }
    public get preparation(): string {
        return this._preparation
    }
    public set preparation(value: string) {
        this._preparation = value
    }
    public get name(): string {
        return this._name
    }
    public set name(value: string) {
        this._name = value
    }
    public get ingredients(): Ingredient[] {
        return this._ingredients
    }
    public set ingredients(value: Ingredient[]) {
        this._ingredients = value
    }
    public get prepTime(): number {
        return this._prepTime
    }
    public set prepTime(value: number) {
        this._prepTime = value
    }
    public get foodType(): string {
        return this._foodType
    }
    public set foodType(value: string) {
        this._foodType = value
    }
    public get flavour(): string {
        return this._flavour
    }
    public set flavour(value: string) {
        this._flavour = value
    }
    public get id(): number {
        return this._id
    }
    public set id(value: number) {
        this._id = value
    }
   
}
    