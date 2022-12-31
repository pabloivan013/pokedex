
export class Pokemon {

  name: string = '';
  weight: string = '0';

  constructor(){
  }

  getData() {
    return 'data: ' + this.name + '-' + this.weight;
  }

}
