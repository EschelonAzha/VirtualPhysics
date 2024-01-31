package symmetrical.electronics

import symmetrical.electronics.interfaces.ICapacitor
import symmetrical.electronics.interfaces.IConductor
import symmetrical.electronics.interfaces.IDiode

interface IElectronics : ICapacitor, IDiode, IConductor {

}