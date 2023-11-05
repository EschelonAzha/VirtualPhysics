package asymmetrical.wormholes.pulsar.plugins.http.director.tasks

import asymmetrical.machine.config.Config
import asymmetrical.wormholes.database.filesystem.LineReader
import asymmetrical.wormholes.pulsar.plugins.http.HttpTask
import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet
import asymmetrical.wormholes.pulsar.plugins.http.writers.SpinWriter
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics.atomic.substance.ions.Compound

open class FileServer : HttpTask {

    constructor(outlet: IOutlet) : super(outlet) {
    }
    override fun run() : Boolean {
        return false
    }
    fun loadFile(fileName: QString) : Compound {
        val readFileName : String   = fileName.quarkValueStr()
        val filePath     : String   = Config.getWebRoot().quarkValueStr()+"/$readFileName"
        val lines        : Compound = LineReader(QString(filePath)).getLines()

        return lines
    }
    fun writeResponse(response:Compound) : Unit {
        SpinWriter(outlet).write(response)
        outlet.flush()
        outlet.close()
    }
}