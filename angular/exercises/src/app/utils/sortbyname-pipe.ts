import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'sortbyname',
  standalone: true
})
export class SortbynamePipe implements PipeTransform {

  transform(value: string[], arg: "asc" | "desc"): string[] {

    return (arg == "asc") ? value.sort() : value.sort((a, b) => { return (a < b) ? 0 : -1 });
  }

}
