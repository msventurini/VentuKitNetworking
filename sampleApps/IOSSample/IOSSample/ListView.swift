//
//  ListView.swift
//  IOSSample
//
//  Created by Matheus Silveira Venturini on 05/03/25.
//


//
//  ListView.swift
//  TesteKmp
//
//  Created by Matheus Silveira Venturini on 05/03/25.
//


import SwiftUI
import VentuKitNetworking

struct ListView: View {
    let numbers: Array<String>
    
    var body: some View {
        List(numbers, id: \.self) {
            Text($0)
        }
    }
}
