import 'package:flutter/material.dart';
import 'dart:async';
import 'package:http/http.dart' as http;
import 'dart:convert';

void main() => runApp(new MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: 'Flutter Demo',
      theme: new ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: new MyHomePage(title: 'Users'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  _MyHomePageState createState() => new _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  Future<List<User>> _getUsers() async {

    var data = await http.get(Uri.parse("https://randomuser.me/api/?results=10"));

    var jsonData = json.decode(data.body);

    List<User> users = [];

    for(var u in jsonData['results']){
      print(jsonData['results']);
      String Name = '${ u["name"]["title"]} ${u["name"]["first"]} ${u["name"]["last"]}';

      String City =  '${u["location"]["city"]}';
      String Contry =  '${u["location"]["country"]}';

      User user = User(u["login"]["uuid"], Name, u["email"], u["phone"],u["picture"]["large"],Contry,City);

      users.add(user);

    }

    print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    print(users.length);

    return users;

  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
        backgroundColor: Colors.blueGrey,
      ),
      backgroundColor: Colors.blueGrey,
      body: Container(
        child: FutureBuilder(
          future: _getUsers(),
          builder: (BuildContext context, AsyncSnapshot snapshot){
            print(snapshot.data);
            if(snapshot.data == null){
              return Container(
                  child:  const Center(
                      child: Text("Loading...")
                  )
              );
            } else {
              return ListView.builder(
                itemCount: snapshot.data.length,
                itemBuilder: (BuildContext context, int index) {
                  return Card (child:ListTile(
                    leading:  CircleAvatar(backgroundImage:
                    NetworkImage(snapshot.data[index].photo)),
                    //snapshot.data[index].picture
                    //): ,),
                    //Colors.lightBlueAccent
                    //backgroundImage: NetworkImage(
                    //snapshot.data[index].picture
                    //),
                    //),
                    title: Text(snapshot.data[index].name),
                    subtitle: Text(snapshot.data[index].email),
                    onTap: (){
                      Navigator.push(context,
                          new MaterialPageRoute(builder: (context) => DetailPage(snapshot.data[index]))
                      );
                    },
                  ));
                },
              );
            }
          },
        ),
      ),
    );
  }
}

class DetailPage extends StatelessWidget {

  final User user;

  DetailPage(this.user);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
        title: Text(
        user.name,
    ),
          backgroundColor: Colors.blueGrey,
    ),
    backgroundColor:Colors.blueGrey ,

    body: Column(

    children: [
    Stack(
    clipBehavior: Clip.none,
    alignment: Alignment.bottomCenter,
    children: [
    Positioned(
    child: CircleAvatar(
    radius: 60,
    backgroundImage:NetworkImage(
        user.photo),
    ),
    )
    ]),
    ListTile(
    title: Text(user.name),
      textColor: Colors.white,
    ),
    ListTile(
    title: Text("Phone : ${user.phone}"),
      textColor: Colors.white,
    ),
    ListTile(
    title: Text("Email : ${user.email}"),
      textColor: Colors.white,
    ),
      ListTile(
    title: Text("Country : ${user.country}"),
        textColor: Colors.white,
    ),ListTile(
    title: Text("City : ${user.city}"),
        textColor: Colors.white,
    ),
    ],
    ),
    );
  }

  }



class User {
  final String id;
  final String name;
  final String email;
  final String phone;
  final String photo;
  final String country;
  final String city;

  User(this.id, this.name, this.email,this.phone,this.photo,this.country,this.city);



}



