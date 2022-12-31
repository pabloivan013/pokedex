import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PokemonBasicComponent } from './pokemon-basic.component';

describe('PokemonBasicComponent', () => {
  let component: PokemonBasicComponent;
  let fixture: ComponentFixture<PokemonBasicComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PokemonBasicComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PokemonBasicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
