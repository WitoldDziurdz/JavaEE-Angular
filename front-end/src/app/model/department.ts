import {Courier} from './courier';

export class Department {
  id: number;
  numberOfWorkers: number;
  address: string;
  couriers: Courier[];
  storage: boolean;
}
