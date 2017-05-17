$TTL 3D
@ IN SOA(
ns1.hotel.es. ;nombre del servidor que tiene que ser el mismo en todos
administrador.hotel.es. ; correo del administrador
1 ; versió
3600 ;
600 ;
86400 ;
60);
@ NS ns1.hotel.es. ; nombre del servidor
ns1 IN A 192.168.0.50 ; 
www IN A 192.168.0.50 ;
;50.0.168.192.in-addre-arpa. IN PTR ns1.hotel.es ; direcció inversa 
