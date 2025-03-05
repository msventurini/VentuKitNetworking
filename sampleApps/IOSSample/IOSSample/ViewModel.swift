//
//  ViewModel.swift
//  IOSSample
//
//  Created by Matheus Silveira Venturini on 05/03/25.
//


//
//  ViewModel.swift
//  TesteKmp
//
//  Created by Matheus Silveira Venturini on 05/03/25.
//


import SwiftUI
import VentuKitNetworking

@Observable class ViewModel: ObservableObject {
    var values: [String] = []
    
    func startObserving() async {
        
        let emittedValues = FlowValuesEmitter().oneToTenFlow()
        
        for await number in emittedValues {
            self.values.append(number)
        }
    }
}
