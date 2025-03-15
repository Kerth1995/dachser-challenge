import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ShipmentService } from '../../services/shipment.service';
import { error } from 'console';
import { FormArray, FormControl, FormGroup } from '@angular/forms';
import { RequestShipmentDTO, Shipment } from '../../entities/Shipment';

@Component({
  selector: 'app-shipment',
  templateUrl: './shipment.component.html',
  styleUrl: './shipment.component.css'
})
export class ShipmentComponent {

  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
  dataSource = ELEMENT_DATA;
  //public dataSource = new MatTableDataSource<any>([]);

  displayedColumnsShipment: string[] = ['id', 'income', 'cost', 'profitLoss'];
  public dataSourceShipment = new MatTableDataSource<Shipment>([]);
  public shipmentList: Shipment [] = [];

  public shipmentForm: FormGroup;

  constructor(public shipmentService: ShipmentService){
    this.shipmentForm = new FormGroup({
      income: new FormControl('', []),
      cost: new FormControl('', []),
      addionalCost: new FormControl('', []),
    });
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll(){
    this.shipmentService.getAll().subscribe({
      next: (data: any) => {
        data.forEach((element:any) => {
          let result: Shipment = {
            id: element.id,
            income: element.income,
            cost: element.cost,
            profitLoss: element.profitLoss
        };
        this.shipmentList.push(result);
        });
        
        this.dataSourceShipment.data = this.shipmentList;
      },
      error: (error) => {

      },
      complete: () => {

      }
    });
  }

  calculateProfitLoss(){
    let costs = [];
    costs.push(this.shipmentForm.get('cost')?.value);
    costs.push(this.shipmentForm.get('addionalCost')?.value);
    let result: RequestShipmentDTO = {
      costs: costs,
      income: this.shipmentForm.get('income')?.value
    }

    this.shipmentService.caulateProfitLoss(result).subscribe({
      next: (response:any) => {
        debugger;
        console.log(response);
        let result: Shipment = {
          id: response.id,
          income: response.income,
          cost: response.cost,
          profitLoss: response.profitLoss
        }
        this.shipmentList.unshift(result);
        this.dataSourceShipment.data = this.shipmentList;
        alert("Shipment already calculated. Its ID is: " + response.id);
      }
      ,error: (error) => {
        alert("There is an error in the request: ");
      },
      complete: () => {

      }
    })
  
  }
}

const ELEMENT_DATA: PeriodicElement[] = [
  {position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
  {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  {position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
  {position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be'},
  {position: 5, name: 'Boron', weight: 10.811, symbol: 'B'},
  {position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C'},
  {position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N'},
  {position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O'},
  {position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F'},
  {position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne'},
];

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

