Entrevoisins

L'application Entrevoisins permet d'ajouter ou de retirer dans une liste, les membres du voisinage. 
Mettre en avant un profil détaillé du voisin et choisir de le mettre le voisin en favoris ou non.
Il y a donc deux listes  séparés par deux onglets, la liste des voisins et celle des favoris.

Dans le code de l'application il y a plusieurs activity qui permettent la gestion des fonctionnalités
 et que ça soit plus clair pour la lecture et pouvoir corriger plus facilement.
Il y a donc une activité pour gérer chaque fonctionnalité.

Pour l'ajout de voisin c'est l'activité AddNeighbourActivity:
 @OnClick(R.id.create)
    void addNeighbour() {
        Neighbour neighbour = new Neighbour(
                System.currentTimeMillis(),
                nameInput.getEditText().getText().toString(),
                mNeighbourImage,
                addressInput.getEditText().getText().toString(),
                phoneInput.getEditText().getText().toString(),
                aboutMeInput.getEditText().getText().toString(),false
        );
c'est un exemple de code dans cette activité. Quand t'on crée un voisin,
on peut ajouter son nom, son image, son numéro, son adresse et des infos sur lui.

Pour l'activité DetailNeighbourActivity qui permet d'afficher les infos sur le voisin:

        TextView Name = findViewById(R.id.person_name);
        Name.setText(name);
        mApiServices = DI.getNeighbourApiService();
        ImageView mAvatar =  findViewById(R.id.avatar_name);
        Glide.with(this)
                .load(neighbour.getAvatarUrl())
                .into(mAvatar);
        TextView localisation = findViewById(R.id.localisation_name);
        localisation.setText(neighbour.getAddress());
        TextView phoneNumber = findViewById(R.id.phoneNumber);
        phoneNumber.setText(neighbour.getPhoneNumber());
        TextView facebook = findViewById(R.id.facebook);
        TextView aboutme = findViewById(R.id.aboutme_name);
        aboutme.setText(neighbour.getAboutMe());

C'est un exemple de code dans cette activité, c'est ce qui permet d'afficher les infos dans la page détail.
Il y a d'autre activité mais nous allons pas toutes les listés.
On peut voir aussi que dans l'application, il y a aussi des tests, pour tester les fonctionnalités;

Dans NeighboursListTest, il y a ce test:
 /**
     * test 3:
     * When we delete an item, the item is no more shown
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        // Given : We remove the element at position 2
        onView(allOf(withId(R.id.list_neighbours), isDisplayed())).check(withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(actionOnItemAtPosition(1, new DeleteViewAction()));
        // Then : the number of element is 11
        onView(allOf(withId(R.id.list_neighbours), isDisplayed())).check(withItemCount(ITEMS_COUNT-1));

    }
Qui permet de supprimer un voisin de la liste.
Il y aussi le layout qui permet de voir le design de l'application.
Dans activity_list_neighbour.xml, il y a le button add:
<android.support.design.widget.FloatingActionButton
        android:id="@+id/add_neighbour"
        app:backgroundTint="@color/colorPrimary"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="end|bottom"
        android:layout_margin="@dimen/fab_margin"
        app:srcCompat="@drawable/ic_person_add_white_24dp" />
il y a plusieurs infos commme l'emplacement et la couleur.
 





 