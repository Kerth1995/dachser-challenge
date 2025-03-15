export interface Shipment {
    id: number;
    income: number;
    cost: number;
    profitLoss: number;
}

export interface RequestShipmentDTO{
    income: number;
    costs: number[];
}