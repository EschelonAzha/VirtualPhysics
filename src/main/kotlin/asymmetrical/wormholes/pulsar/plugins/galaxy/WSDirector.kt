package asymmetrical.wormholes.pulsar.plugins.galaxy

import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet
import asymmetrical.wormholes.pulsar.plugins.Director
import asymmetrical.wormholes.pulsar.plugins.InspectorTask
import asymmetrical.wormholes.pulsar.plugins.galaxy.director.inspectors.*
import asymmetrical.wormholes.pulsar.plugins.galaxy.director.tasks.*

class WSDirector : Director {

    object Static {
        const val LAST = Director.Static.LAST
    }
    private val plugin :WSServerPlugin
    constructor(plugin:WSServerPlugin,outlet: IOutlet) : super(outlet) {
        this.plugin = plugin
        add(InspectorTask(WSFrameContinuationInspector(), WSFrameContinuationTask  (plugin, outlet)))
        add(InspectorTask(WSFrameTextInspector        (), WSFrameTextTask          (plugin, outlet)))
        add(InspectorTask(WSFrameBinaryInspector      (), WSFrameBinaryTask        (plugin, outlet)))
        add(InspectorTask(WSFrameCloseInspector       (), WSFrameCloseTask         (plugin, outlet)))
        add(InspectorTask(WSFramePingInspector        (), WSFramePingTask          (plugin, outlet)))
        add(InspectorTask(WSFramePongInspector        (), WSFramePongTask          (plugin, outlet)))
    }
}