package asymmetrical.wormholes.pulsar.plugins.http



import asymmetrical.wormholes.pulsar.plugins.http.director.inspectors.HomePage
import asymmetrical.wormholes.pulsar.plugins.http.director.inspectors.JSLoader
import asymmetrical.wormholes.pulsar.plugins.http.director.inspectors.WebSocketUpgrade
import asymmetrical.wormholes.pulsar.plugins.http.director.tasks.responses.JSWriter
import asymmetrical.wormholes.pulsar.plugins.http.director.tasks.responses.LoadHomePage
import asymmetrical.wormholes.pulsar.plugins.http.director.tasks.responses.UpgradeWebSocket
import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet
import asymmetrical.wormholes.pulsar.plugins.Director
import asymmetrical.wormholes.pulsar.plugins.InspectorTask


class HttpDirector : Director {

    object Static {
        const val LAST = Director.Static.LAST
    }
    constructor(outlet: IOutlet) : super(outlet) {
        add(InspectorTask(HomePage        (), LoadHomePage    (outlet)))
        add(InspectorTask(JSLoader        (), JSWriter        (outlet)))
        add(InspectorTask(WebSocketUpgrade(), UpgradeWebSocket(outlet)))
    }
}