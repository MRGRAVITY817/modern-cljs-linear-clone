# Linear Clone - HSX & RFX

This project is a Linear app clone built using ClojureScript with HSX for UI components and RFX for state management. It demonstrates modern ClojureScript development with a functional todo list implementation.

## Technology Stack

- **ClojureScript** - Core language
- [**Shadow CLJS**](https://shadow-cljs.github.io/docs/UsersGuide.html) - Build tool and development environment
- [**HSX**](https://github.com/factorhouse/hsx) - Modern React 19 compatible UI library (alternative to Reagent)
- [**RFX**](https://github.com/factorhouse/rfx) - State management library (alternative to Re-frame)
- [**Datascript**](https://github.com/tonsky/datascript) - Client-side database (planned for future features)
- [**Tailwind CSS**](https://tailwindcss.com/) - Utility-first CSS framework

## Quick Start

### Prerequisites

- Node.js (v16 or higher)
- Java 8+ (for ClojureScript compilation)

### Installation

```bash
# Install dependencies
npm install

# Build Tailwind CSS
npm run css:build
```

### Development

```bash
# Start the development server (runs on http://localhost:8080)
npm run dev

# In another terminal, watch and build CSS
npm run css:build
```

The development server includes hot reloading - changes to ClojureScript files will automatically update in the browser.

### Production Build

```bash
# Build CSS for production
npm run css:prod

# Build ClojureScript for production
npm run build
```

### Other Commands

```bash
# Start ClojureScript REPL
npm run repl

# Run tests
npm run test

# Clean build artifacts
npm run clean
```

## Project Structure

```
src/
├── css/
│   └── input.css          # Tailwind CSS input file
└── hsx_example/
    ├── core.cljs          # Application entry point
    ├── db.cljs            # Default database state
    ├── events.cljs        # RFX event handlers
    ├── subs.cljs          # RFX subscriptions
    └── views.cljs         # HSX components

public/
├── index.html             # HTML template
├── css/
│   └── output.css         # Generated Tailwind CSS
└── js/                    # Generated JavaScript (after build)

shadow-cljs.edn            # Shadow CLJS configuration
tailwind.config.js         # Tailwind CSS configuration
```

## Current Features

✅ **Todo List Application**
- Add new todos
- Mark todos as complete/incomplete
- Delete todos
- Filter todos (All, Active, Completed)
- Responsive design with Tailwind CSS

## Development Notes

### HSX Components

HSX uses React-style functional components with hooks:

```clojure
(defnc my-component [{:keys [prop1 prop2]}]
  (let [state (hsx/use-state initial-value)]
    [:div "Hello World"]))
```

### RFX Events & Subscriptions

Events modify the application state:

```clojure
(rfx/reg-event-db
 :event-name
 (fn [db [_ param]]
   (assoc db :key param)))
```

Subscriptions derive data from state:

```clojure
(rfx/reg-sub
 :sub-name
 (fn [db _]
   (:key db)))
```

### Styling

Uses Tailwind CSS classes directly in HSX components:

```clojure
[:div {:class "bg-blue-500 text-white p-4 rounded"}
 "Styled content"]
```

## Roadmap

Future Linear-inspired features:
- [ ] Issue management system
- [ ] Project organization
- [ ] Kanban board view
- [ ] Search and filtering
- [ ] Datascript integration for data persistence

## Troubleshooting

**Port already in use**: Change the port in `shadow-cljs.edn` dev-http section.

**CSS not updating**: Make sure `npm run css:build` is running in watch mode.

**JavaScript errors**: Check the browser console and Shadow CLJS output for compilation errors.

For more help, see the [Shadow CLJS User Guide](https://shadow-cljs.github.io/docs/UsersGuide.html).
