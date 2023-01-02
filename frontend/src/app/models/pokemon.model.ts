
export class Pokemon {

  name: string = '';
  weight: string = '0';
  sprites: any = '';

  constructor(){
  }

  getData() {
    return 'data: ' + this.name + '-' + this.weight;
  }

}
