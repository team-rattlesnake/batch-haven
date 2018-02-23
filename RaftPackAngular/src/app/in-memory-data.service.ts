import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Profile } from './profile';



export class InMemoryDataService implements InMemoryDbService {

    createDb() {
        const profile = [{
            id: 123,
            name: 'Mary Nguyen',
            gender: 'female',
            email: 'mnguyen5081@gmail.com',
            password: 'password',
            DOB: new Date('1993-07-21:15:05:05').toDateString()
        }];
        return { profile };
    }
}
