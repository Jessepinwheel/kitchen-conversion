����   4 ]  UnitBase  java/lang/Object imperial Z volume convert D name Ljava/lang/String; abrv <init> *(Ljava/lang/String;Ljava/lang/String;DZZ)V Code
     ()V��      	    		   
 	    	    	     LineNumberTable LocalVariableTable this 
LUnitBase; unitName unitAbrv unitConv unitImp unitVol setName (Ljava/lang/String;)V setAbrv 
setConvert (D)V setConv setImperial (Z)V setImp 	setVolume setVol getName ()Ljava/lang/String; getAbrv 
getConvert ()D getImperial ()Z 	getVolume 	printUnit	 = ? > java/lang/System @ A out Ljava/io/PrintStream; C java/lang/StringBuilder E name: 
 B G  )
 B I J K append -(Ljava/lang/String;)Ljava/lang/StringBuilder; M , abbreviation:  O , conversion rate: 
 B Q J R (D)Ljava/lang/StringBuilder;
 B T U 4 toString
 W Y X java/io/PrintStream Z ) println 
SourceFile UnitBase.java !                  	    
                 �     '*� * � *+� *,� *)� *� *� �       "                  &      >    ' ! "     ' #     ' $     ' % 	    ' &     ' '          >     *� * � �                         ! "    ( )     >     *+� �       
    "  #          ! "      (    * )     >     *+� �       
    &  '          ! "      *    + ,     >     *'� �       
    *  +          ! "      - 	   . /     >     *� �       
    .  /          ! "      0    1 /     >     *� �       
    2  3          ! "      2    3 4     /     *� �           7          ! "    5 4     /     *� �           ;          ! "    6 7     /     *� �           ?          ! "    8 9     /     *� �           B          ! "    : 9     /     *� �           F          ! "    ;      `     2� <� BYD� F*� � HL� H*� � HN� H*� � P� S� V�       
    K 1 L         2 ! "    [    \