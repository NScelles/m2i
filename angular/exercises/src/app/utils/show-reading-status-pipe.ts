import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'showReadingStatus',
  standalone: true
})
export class ShowReadingStatusPipe implements PipeTransform {

  transform(status: boolean): string {
    return status ? "👍" : "👎";
  }

}
