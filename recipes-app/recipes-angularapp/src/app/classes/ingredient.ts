export class Ingredient {
    
    constructor(
        private _product: string,
        private _quantity: string
    ) {}

    public get quantity(): string {
        return this._quantity;
    }
    public set quantity(value: string) {
        this._quantity = value;
    }
    public get product(): string {
        return this._product;
    }
    public set product(value: string) {
        this._product = value;
    }
}
